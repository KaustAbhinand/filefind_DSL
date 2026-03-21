@echo off
java -jar C:\antlr\antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener %1.g4
javac -cp ".;C:\antlr\antlr-4.13.2-complete.jar" *.java
echo.
echo ===== Done =====
pause