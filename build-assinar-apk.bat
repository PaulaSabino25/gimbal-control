@echo off
REM Script para compilar e assinar APK Android no Windows

REM === VARIÁVEIS ===
set ALIAS=gimbal-control
set PASSWORD=123456
set KEYSTORE=gimbal-keystore.jks
set ORG="Paula Sabino"
set FINAL_APK=cliente-gimbal.apk
set APK_PATH=app\build\outputs\apk\release\app-release.apk
set SIGNED_APK=%FINAL_APK%

REM === GERAR KEYSTORE SE NÃO EXISTIR ===
if not exist %KEYSTORE% (
    echo Gerando keystore...
    keytool -genkey -v -keystore %KEYSTORE% -keyalg RSA -keysize 2048 -validity 10000 -alias %ALIAS% -storepass %PASSWORD% -keypass %PASSWORD% -dname "CN=%ORG%, OU=Dev, O=%ORG%, L=City, S=State, C=BR"
)

REM === COMPILAR APK RELEASE ===
echo Compilando APK...
call .\gradlew.bat assembleRelease

if exist "%APK_PATH%" (
    echo APK gerado com sucesso: %APK_PATH%
) else (
    echo ERRO: APK nao foi gerado.
    exit /b 1
)

REM === ASSINAR O APK ===
echo Assinando o APK...
apksigner sign ^
  --ks %KEYSTORE% ^
  --ks-key-alias %ALIAS% ^
  --ks-pass pass:%PASSWORD% ^
  --key-pass pass:%PASSWORD% ^
  --out %SIGNED_APK% ^
  %APK_PATH%

if %errorlevel%==0 (
    echo APK assinado com sucesso: %SIGNED_APK%
) else (
    echo ERRO ao assinar o APK.
    exit /b 1
)

echo Processo finalizado. O arquivo assinado está em: %SIGNED_APK%
pause
