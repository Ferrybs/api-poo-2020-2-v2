package br.com.empresa.notificacao

import java.lang.RuntimeException

class CredencialInvalida(
        mensagem: String
): RuntimeException(mensagem)