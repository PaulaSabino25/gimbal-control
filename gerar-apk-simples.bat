@echo off
echo ================================
echo GERANDO APK PARA O CLIENTE
echo ================================

echo Compilando APK de debug...
call .\gradlew.bat assembleDebug

set APK_DEBUG=app\build\outputs\apk\debug\app-debug.apk

if exist "%APK_DEBUG%" (
    echo.
    echo ✅ APK GERADO COM SUCESSO!
    echo.
    echo 📁 Arquivo: %APK_DEBUG%
    echo.
    echo 📱 INSTRUCOES PARA O CLIENTE:
    echo 1. Baixe o arquivo app-debug.apk
    echo 2. No celular, va em Configuracoes ^> Seguranca
    echo 3. Ative "Fontes desconhecidas" ou "Instalar apps desconhecidos"
    echo 4. Abra o arquivo APK e instale
    echo.
    echo 🎯 O app está pronto para usar!
    echo.
) else (
    echo ❌ ERRO: APK nao foi gerado
    echo Verifique se o Gradle está funcionando
)

pause
