Feature: Registro usuarios nuevos en signaturit

  Scenario: Inciar aplicacion
    Given Iniciar navegar
    When Poner la Url Acceda a esta URL:" https://app.signaturit.com/es"
    And Hacer Clic en "Enter"
    Then Mostrar el la pantalla principal de login en signaturit

  Scenario: Ir a la pesta�a del formulario
    Given Acceder al formulario
    When Hacer Clic en "Conseguir una aqui"
    Then Mostrar el la pantalla del fomulario

  Scenario Outline: Completar todos los campos del formulario
    Given Nombre "<nombre>"
    And Apellido "<apellido>"
    And Nombre de la empresa "<nombreEmpresa>"
    And Cargo de la empresa "<cargoEmpresa>"
    And Telefono "<telefono>"
    And Email de la empresa "<emailEmpresa>"
    And Contrase�a "<contrase�a>"
    When Hacer Click en "Acepto la pol�tica de privacidad y condiciones de contrataci�n"
    And Hacer Clic en "Reg�strate gratis"
    Then Mostrar el siguiente mensaje: "<validacionMensaje>"

    Examples: 
      | nombre | apellido | nombreEmpresa | cargoEmpresa | telefono    | emailEmpresa     | contrase�a | validacionMensaje                |
      | jose   | perez    | empresa1      | gerente      | 34000000000 | empresa1@test.es | ABCD1234   | Usuario registrado correctamente |


  Scenario Outline: Completar todos los campos del formulario (Caso de prueba negativo)
    Given Comprobar que todo los campos son obligatorios
    When Dejar todo los campos vacios
    And Hacer Clic en "Reg�strate gratis"
    Then Mostrar el siguiente mensaje: "Los campos no son validos, no pueden estar vacios"

