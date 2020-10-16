package com.company.notification.exception

import java.lang.RuntimeException

class InvalidCredential(
        message: String
): RuntimeException(message)