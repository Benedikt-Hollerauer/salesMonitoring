package mock.inputMock

import boundary.input.CreateSaleInput
import mock.entityMock.SaleEntityMock

object CreateSaleInputMock extends CreateSaleInput(
    saleEntity = SaleEntityMock
)

val CreateSaleInputToShortTitleFailureMock: CreateSaleInput = CreateSaleInputMock.copy(saleEntity = SaleEntityMock.saleEntityToShortTitleFailureMock)