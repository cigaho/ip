@echo off
chcp 65001 > nul
cd /d "%~dp0"

echo 编译...
javac -d classes -encoding UTF8 src/main/java/freddy/*.java src/main/java/freddy/**/*.java

echo 创建JAR...
echo Main-Class: freddy.Freddy > manifest.txt
jar cvfm Freddy.jar manifest.txt -C classes .

echo 清理...
if exist classes rmdir /s /q classes
del manifest.txt

echo 完成！JAR文件: Freddy.jar
pause