# language: es

@FeatureName:FuncionamientoDelCarroDeCompras
Característica: Funcionamiento del carro de compras
  yo como cliente
  quiero tener un carro de compras funcional
  para poder agregar productos y comprarlos

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de SignIn
    Y que el usuario se registra correctamente en la tienda

  @ScenarioName:AgregarUnProductoAlCarroDeCompras
  Escenario: Agregar un producto al carro de compras
    Cuando el usuario navega a la seccion dresses, agrega un producto al carro de compras y navega al carrito
    Entonces el carro de compras debe contener el producto agregado

  @ScenarioName:AgregarOtraUnidadDeUnProductoDesdeElCarroDeCompras
  Escenario: Agregar otra unidad de un producto desde el carro de compras
    Dado el usuario agrega una unidad de un producto al carro de compras y navega hacia el carrito
    Cuando el usuario suma una unidad del producto agregado
    Entonces el precio total sera el doble del precio por unidad
