package com.company.notification

import java.lang.RuntimeException

class InvalidCredential(
        message: String
): RuntimeException(message)