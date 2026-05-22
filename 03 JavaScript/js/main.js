// Carga de categorias

const cargarCategorias = () => {

    const listaCategorias = document.getElementById("listaCategorias");

    categorias.forEach((categoria) => {

        const item = document.createElement("li");
        item.innerHTML = `
            <a href="#">${categoria}</a>
        `;

        listaCategorias.appendChild(item);
    });

};

// Carga de productos

const cargarProductos = () => {

    const contenedorProductos = document.getElementById("contenedorProductos");

    productos.forEach((producto) => {

        const article = document.createElement("article");
        article.innerHTML = `
        
            <img 
                src="${producto.imagen}" 
                alt="${producto.nombre}" 
                width="300px"
            >

            <h3>${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p><strong>$${producto.precio}</strong></p>

            <button>
                Agregar
            </button>

            <br><br>
        
        `;

        // Boton agregar
        const boton = article.querySelector("button");
        boton.addEventListener("click", () => {

            alert(`Agregaste: ${producto.nombre}`);

        });

        // Agregamos article al contenedor
        contenedorProductos.appendChild(article);

    });

};

// Ejecucion
cargarCategorias();
cargarProductos();