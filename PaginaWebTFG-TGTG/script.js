const productsContainer = document.querySelector('.products');
const cartContainer = document.querySelector('.productoCard');
const totalElement = document.querySelector('.precio');

let cart = [];
let total = 0;
let count = 0;

document.addEventListener('DOMContentLoaded', () => {
    loadProducts();
    productsContainer.addEventListener('click', addToCart);
    cartContainer.addEventListener('click', removeFromCart);
    document.querySelector('.input').addEventListener('input', filterProducts);

    const navLinks = document.querySelectorAll('.pagina');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            sessionStorage.setItem('cart', JSON.stringify(cart));
            window.location.href = e.target.href;
        });
    });
    const storedCart = JSON.parse(sessionStorage.getItem('cart'));
    if (storedCart) {
        cart = storedCart;
        updateCart();
    }
});

function loadProducts() {
    renderProducts(baseDeDatos);
}

function filterProducts() {
    const searchText = this.value.toLowerCase();
    const filteredProducts = baseDeDatos.filter(product => {
        return product.nombreProducto.toLowerCase().includes(searchText) ||
               product.descripcion.toLowerCase().includes(searchText);
    });
    renderProducts(filteredProducts);
}

function renderProducts(products) {
    productsContainer.innerHTML = '';
    products.forEach(product => {
        const productHTML = `
            <div class="carts">
                <div>
                    <img src="${product.imagen}" alt="${product.nombreProducto}">
                    <p><span>${product.precio}</span>€</p>
                </div>
                <p class="title">${product.nombreProducto}</p>
                <p>${product.descripcion}</p>
                <a href="#" data-id="${product.id}" class="btn-add-cart">Add to Cart</a>
            </div>
        `;
        productsContainer.innerHTML += productHTML;
    });
}

function addToCart(e) {
    e.preventDefault();
    if (e.target.classList.contains('btn-add-cart')) {
        const productId = e.target.getAttribute('data-id');
        const product = baseDeDatos.find(p => p.id == productId);
        const productInCart = cart.find(p => p.id == productId);

        if (productInCart) {
            productInCart.cantidad++;
        } else {
            cart.push({ ...product, cantidad: 1 });
        }

        updateCart();
    }
}

function removeFromCart(e) {
    if (e.target.classList.contains('delete-product')) {
        const productId = e.target.getAttribute('data-id');
        cart = cart.filter(product => product.id != productId);
        updateCart();
    }
}

function updateCart() { 
    cartContainer.innerHTML = ''; 
    total = 0; 
    count = 0; 
 
    cart.forEach(product => { 
        total += product.precio * product.cantidad; 
        count += product.cantidad; 
 
        const cartItem = ` 
            <div class="item"> 
                <img src="${product.imagen}" alt="${product.nombreProducto}"> 
                <div class="item-content"> 
                    <h5>${product.nombreProducto}</h5> 
                    <h5 class="cart-price">${product.precio}€</h5> 
                    <h6>Amount: ${product.cantidad}</h6> 
                </div> 
                <span class="delete-product" data-id="${product.id}">X</span> 
            </div> 
        `; 
        cartContainer.innerHTML += cartItem; 
    }); 
 
    totalElement.innerHTML = total.toFixed(2); 
    countElement.innerHTML = count; 
 
    sessionStorage.setItem('cart', JSON.stringify(cart));
}


window.addEventListener('DOMContentLoaded', (event) => {
    setInterval(changeTitle, 8000);
});

function changeTitle() {
    const tituloPrincipal = document.querySelector('.tituloPrincipal');
    const titles = ["¡Descubre nuestras ofertas exclusivas!", "¡Explora nuestras nuevas ofertas!"];
    const animationDuration = 2000;
    const currentTitle = tituloPrincipal.textContent;
    const newTitle = currentTitle === titles[0] ? titles[1] : titles[0];

    tituloPrincipal.style.transition = `transform ${animationDuration / 1000}s ease-out`;
    tituloPrincipal.style.transform = 'translateY(-100%)';

    setTimeout(() => {
        tituloPrincipal.textContent = newTitle;
        tituloPrincipal.style.transform = 'translateY(0)';
    }, animationDuration);
}

setTimeout(function() {
    document.getElementById('popup').style.display = 'block';
}, 10000); 

document.getElementById('close-popup').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'none';
});


function showCart() {
  document.getElementById("productosId").style.display = "block";
}
function closeBtn() {
  document.getElementById("productosId").style.display = "none";
}

document.querySelector('.comprar-btn').addEventListener('click', function() {
    document.querySelector('.productoCard').innerHTML = '';
    document.querySelector('.precio').textContent = '0';
});

document.querySelector('.comprar-btn').addEventListener('click', function() {
    sessionStorage.setItem('cart', JSON.stringify(cart));
    window.location.href = 'pago.html';
});

document.addEventListener('DOMContentLoaded', () => {
    const botonFiltros = document.querySelector('.boton-filtros');
    const opcionesFiltro = document.querySelector('.opciones-filtro');
    const botonOrdenarPrecioMenorMayor = document.querySelector('.BotonOrdenarPrecioMenorMayor');
    const botonOrdenarPrecioMayorMenor = document.querySelector('.BotonOrdenarPrecioMayorMenor');

    botonFiltros.addEventListener('click', () => {
        opcionesFiltro.style.display = opcionesFiltro.style.display === 'block' ? 'none' : 'block';
    });

    botonOrdenarPrecioMenorMayor.addEventListener('click', () => {
        baseDeDatos.sort((a, b) => a.precio - b.precio);
        renderProducts(baseDeDatos);
    });

    botonOrdenarPrecioMayorMenor.addEventListener('click', () => {
        baseDeDatos.sort((a, b) => b.precio - a.precio);
        renderProducts(baseDeDatos);
    });
});





