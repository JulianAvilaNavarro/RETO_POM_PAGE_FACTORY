Feature: Compra de productos
  como cliente deseo ingresar a la pagina de zonafit y visualizar diferentes productos deportivos
  con el fin de comprar productos segun su marca o categoria


  Background:
    Given El cliente se encuentra en la pagina de zonafit
  @regresion
  Scenario:  El cliente desea comprar un producto de una marca
    When el cliente escoge el producto y llena su formulario
    Then la pagina debera mostrar un mensaje indicando que fue pedido el producto

  @regresion
  Scenario: El cliente desea comprar productos en oferta
    When el cliente selecciona los productos que desea comprar y llena el formulario
    Then la pagina debera mostrar un mensaje indicando que fueron pedidos los productos