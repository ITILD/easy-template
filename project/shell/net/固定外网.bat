netsh interface ip set address name="��������" source=static addr=192.168.0.173 mask=255.255.252.0 gateway=192.168.1.1
netsh interface ip set dns name="��������" source=static addr=114.114.114.114 register=PRIMARY
netsh interface ip add dns name="��������" addr=1.1.1.1 index=2 