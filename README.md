# Gimbal Control App

Este aplicativo Android permite controlar o gimbal M01 via Bluetooth BLE.

## Funcionalidades
- Ligar/desligar o gimbal
- Alternar modo do gimbal
- Controlar movimentos com joystick virtual

## Requisitos
- Android 6.0 (API 23) ou superior
- Permissões de Bluetooth e Localização

## Instalação
1. Instale o APK no seu dispositivo Android.
2. Conceda as permissões solicitadas.
3. Ligue o gimbal M01 e conecte via Bluetooth.

## Uso
- Use os botões grandes para ligar/desligar e alternar modo.
- Use o joystick para mover o gimbal.

## Observações
- Os comandos BLE devem ser ajustados conforme o protocolo do gimbal M01 (UUIDs e payloads).
- Este APK é de debug e não está assinado para publicação na Play Store. Ele serve apenas para testes e validação.
- Para produção, gere o APK de release e assine digitalmente.

Como gerar o APK
1. Clone o repositório:

git clone https://github.com/PaulaSabino25/gimbal-control.git

2. Abra o projeto no Android Studio.

3. No menu, selecione Build > Build APK(s).

4. O APK gerado estará na pasta:

app/build/outputs/apk/debug/app-debug.apk

5. Transfira o APK para o dispositivo Android e instale normalmente.


