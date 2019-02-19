Feature: Registro usuarios nuevos en signaturit

  Scenario Outline: Completar todos los campos del formulario
    Given Nombre <nombre>
    And Apellido <apellido>
    And Nombre_empresa <nombreEmpresa>
    And Cargo_empresa <cargoEmpresa>
    And Telefono <telefono>
    And Email empresa <emailEmpresa>
    And PassWork <contrasena>
    When Hacer_Click "Acepto la política de privacidad y condiciones de contratación"
    Then Mostrar_siguiente_mensaje: <validacionMensaje>

    Examples: 
      | nombre | apellido | nombreEmpresa | cargoEmpresa | telefono  | emailEmpresa     | contrasena | validacionMensaje                |
      | jose   | perez    | empresa1      | gerente      | e59448994 | empresa1@test.es | ABCD1234   | Usuario registrado correctamente |
