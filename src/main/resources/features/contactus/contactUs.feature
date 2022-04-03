# language: es
@FeatureName:contactarseConLaTienda
Característica: Contactarse con la tienda
  yo como cliente
  quiero poder enviar un mensaje a la tienda
  para poder contactarme con ellos y resolver problemas

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de contact us

  @ScenarioName:EnviarUnMensajeLlenandoElFormularioCompleto
  Escenario: Enviar un mensaje llenando el formulario completo
    Cuando el usuario envia un mensaje llenando todos los campos
    Entonces el sistema mostara un mensaje de envio exitoso

  @ScenarioName:ContactarseConLaTiendaSinSeleccionarUnTema
  Escenario: Contactarse con la tienda sin seleccionar un tema
    Cuando el usuario intenta enviar un mensaje sin seleccionar un tema
    Entonces el sistema mostrara un mensaje de error

