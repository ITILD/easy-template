package com.example.spmvc.basetest.utils.tencentCloud;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vpc.v20170312.VpcClient;
import com.tencentcloudapi.vpc.v20170312.models.*;

public class TencentcloudapiUsual
{
    static String SecretId_api_user0 = "AKIDud6KHxMVO0LOn0xd3C4fz3qNddS1KODm"; 
    static String SecretKey_api_user0 = "LRItEJ9j37wWquiHaeS1KNBk36tVszqR";
    /**
     * 测试腾讯云安全组
     */
    public static void getTCSecurity() {
        try{
            // String 主账号ID 100020042604 
            // 用户名 api_user0 
            // 登录密码 - 

            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(SecretId_api_user0, SecretKey_api_user0);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vpc.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VpcClient client = new VpcClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DescribeSecurityGroupsRequest req = new DescribeSecurityGroupsRequest();
            
            // 返回的resp是一个DescribeSecurityGroupsResponse的实例，与请求对象对应
            DescribeSecurityGroupsResponse resp = client.DescribeSecurityGroups(req);
            // 输出json格式的字符串回包
            System.out.println(DescribeSecurityGroupsResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }


    /**
     * 查看安全组规则
     */
    public static String getTCSecurityOne() {
        String result = "";
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(SecretId_api_user0, SecretKey_api_user0);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vpc.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VpcClient client = new VpcClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DescribeSecurityGroupPoliciesRequest req = new DescribeSecurityGroupPoliciesRequest();
            req.setSecurityGroupId("sg-619pq985");
            // 返回的resp是一个DescribeSecurityGroupPoliciesResponse的实例，与请求对象对应
            DescribeSecurityGroupPoliciesResponse resp = client.DescribeSecurityGroupPolicies(req);
            // 输出json格式的字符串回包
            result = DescribeSecurityGroupPoliciesResponse.toJsonString(resp);
            System.out.println(result);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
       
    }



    /**
     * 修改单个安全组一条规则
     */
    public static String changeTCSecurityOne(String newIp) {
        String result = "";
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(SecretId_api_user0, SecretKey_api_user0);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vpc.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VpcClient client = new VpcClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            ReplaceSecurityGroupPolicyRequest req = new ReplaceSecurityGroupPolicyRequest();
            req.setSecurityGroupId("sg-619pq985");
            SecurityGroupPolicySet securityGroupPolicySet1 = new SecurityGroupPolicySet();

            SecurityGroupPolicy[] securityGroupPolicys1 = new SecurityGroupPolicy[1];
            SecurityGroupPolicy securityGroupPolicy1 = new SecurityGroupPolicy();
            securityGroupPolicy1.setPolicyIndex(2L);
            securityGroupPolicy1.setProtocol("tcp");
            securityGroupPolicy1.setPort("8888,8889,5000,5001,8080,8081");
            securityGroupPolicy1.setCidrBlock(newIp);
            securityGroupPolicy1.setAction("ACCEPT");
            securityGroupPolicy1.setPolicyDescription("手机/快速临时/api");
            securityGroupPolicys1[0] = securityGroupPolicy1;

            securityGroupPolicySet1.setIngress(securityGroupPolicys1);

            req.setSecurityGroupPolicySet(securityGroupPolicySet1);

            // 返回的resp是一个ReplaceSecurityGroupPolicyResponse的实例，与请求对象对应
            ReplaceSecurityGroupPolicyResponse resp = client.ReplaceSecurityGroupPolicy(req);
            // 输出json格式的字符串回包
            System.out.println(ReplaceSecurityGroupPolicyResponse.toJsonString(resp));
            result = "替换为:  "+ newIp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }


}

