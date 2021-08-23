netsh interface ip set address name="本地连接" source=static addr=192.168.0.173 mask=255.255.252.0 gateway=192.168.1.1
netsh interface ip set dns name="本地连接" source=static addr=114.114.114.114 register=PRIMARY
netsh interface ip add dns name="本地连接" addr=1.1.1.1 index=2 