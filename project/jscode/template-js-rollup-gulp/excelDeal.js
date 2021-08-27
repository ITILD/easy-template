let excelpath = 'c:/Users/Administrator/Desktop/王旭实验数据.xlsx'
let outFilesPath = 'e:/wangxu/共享/test0/'
let filesIn = [
  {
    share: '\\\\192.168.0.173\\共享', //共享文件夹地址
    domain: 'DOMAIN',
    username: 'Administrator', //用户名
    password: '123', //密码
  },
  {
    share: '\\\\192.168.11.200\\nas5', //共享文件夹地址
    domain: 'DOMAIN',
    username: 'Administrator', //用户名
    password: '123', //密码
  },
]
console.log('start')
import fs from 'fs'
import path from 'path'
import SMB2 from 'smb2'
import ExcelJS from 'exceljs'
import { access } from 'fs/promises'
import { constants } from 'fs'

/**
 * 创建文件夹
 * @param {*} reaPath
 */
let exitsFolder = async function (reaPath) {
  try {
    await access(reaPath, constants.W_OK)
  } catch {
    fs.mkdir(reaPath, { recursive: true }, (err) => {
      if (err) console.log('新建文件夹失败!!!!', reaPath)
      console.log('新建文件夹', reaPath)
    })
  }
}

let smb2ClientMap = new Map()
filesIn.forEach((element) => {
  smb2ClientMap.set(element.share, new SMB2(element))
})

const workbook = new ExcelJS.stream.xlsx.WorkbookReader(excelpath)

let count = 0
for await (const worksheet of workbook) {
  // console.log(worksheet.name)//通常sheet初始三个
  for await (const row of worksheet) {
    let infilePath = row.getCell(3).value
    let infileArray = infilePath.split('\\')
    if (
      infileArray[2]&&infileArray[3]&&
      row.getCell(2).value
      // &&
      // row.getCell(2).value == 'test.txt'
    ) {
      let realPath = '\\\\' + infileArray[2] + '\\' + infileArray[3]
      let inRealFile =
        row.getCell(3).value.replace(realPath + path.sep, '') +
        path.sep +
        row.getCell(2).value
      // console.log('::::', realPath, inRealFile)
      let smb2Client = smb2ClientMap.get(realPath)
      smb2Client.readFile(
        inRealFile,
        { flag: 'r+', encoding: 'utf8' },
        (err, data) => {
          //设置编码格式
          if (err) {
            console.log('！！！！！！！！！！输入路径不存在',inRealFile)
            return
          }
          // console.log(data) //data就是读取的字符
          let outFilePath = outFilesPath + row.getCell(4).value
          exitsFolder(outFilePath).then(() => {
            fs.writeFile(
              outFilePath + path.sep + row.getCell(2).value,
              data,
              (err) => {
                if (err) return
                console.log(++count)
              }
            )
          })
        }
      )
    }
  }
}
