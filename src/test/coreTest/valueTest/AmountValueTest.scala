package coreTest.valueTest

import core.value.AmountValue
import error.valueError.AmountValueError
import zio.test.*
import zio.*

object AmountValueTest extends ZIOSpecDefault:

    def spec =
        suite(s"${AmountValue.getClass.getSuperclass}")(
            suite(".fromInt should return")(
                test(s"${AmountValue.getClass.getSuperclass}")(
                    for
                        mayBeAmountValue <- AmountValue.fromInt(
                            mayBeAmount = 1
                        )
                    yield assertTrue(mayBeAmountValue.isInstanceOf[AmountValue])
                ),

                test(s"${AmountValueError.AmountIsZero.getClass.getSimpleName}")(
                    for
                        mayBeAmountValue <- AmountValue.fromInt(
                            mayBeAmount = 0
                        ).cause
                        expected <- ZIO.fail(
                            AmountValueError.AmountIsZero(0)
                        ).cause
                    yield assertTrue(mayBeAmountValue == expected)
                ),

                test(s"${AmountValueError.AmountIsNegative.getClass.getSimpleName}")(
                    for
                        mayBeAmountValue <- AmountValue.fromInt(
                            mayBeAmount = -5
                        ).cause
                        expected <- ZIO.fail(
                            AmountValueError.AmountIsNegative(-5)
                        ).cause
                    yield assertTrue(mayBeAmountValue == expected)
                )
            )
        )