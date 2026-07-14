const STORAGE_KEY = "shopping-cart-items";
const products = [
  { id: 1, name: "咖啡", price: 28 },
  { id: 2, name: "书本", price: 45 },
  { id: 3, name: "耳机", price: 199 },
  { id: 4, name: "笔记本", price: 89 },
];

let cart = [];

const productListEl = document.querySelector("#product-list");
const cartListEl = document.querySelector("#cart-list");
const totalPriceEl = document.querySelector("#total-price");

function loadCart() {
  try {
    const stored = localStorage.getItem(STORAGE_KEY);
    cart = stored ? JSON.parse(stored) : [];
  } catch (error) {
    console.error("读取购物车失败", error);
    cart = [];
  }
}

function saveCart() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(cart));
}

function renderProducts() {
  productListEl.innerHTML = products
    .map((product) => {
      return `
        <div class="product-item">
          <div class="product-info">
            <strong>${product.name}</strong>
            <span>¥${product.price}</span>
          </div>
          <button class="add-btn" data-id="${product.id}" type="button">加入购物车</button>
        </div>
      `;
    })
    .join("");
}

function renderCart() {
  if (cart.length === 0) {
    cartListEl.innerHTML = '<li class="cart-item">购物车为空</li>';
    totalPriceEl.textContent = "¥0.00";
    return;
  }

  cartListEl.innerHTML = cart
    .map((item) => {
      return `
        <li class="cart-item">
          <div>
            <strong>${item.name}</strong>
            <div>${item.quantity} 件</div>
          </div>
          <div>
            <button class="quantity-btn" data-action="decrease" data-id="${item.id}">-</button>
            <button class="quantity-btn" data-action="increase" data-id="${item.id}">+</button>
          </div>
        </li>
      `;
    })
    .join("");

  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  totalPriceEl.textContent = `¥${total.toFixed(2)}`;
}

function addToCart(productId) {
  const product = products.find((item) => item.id === productId);
  if (!product) return;

  const existing = cart.find((item) => item.id === productId);
  if (existing) {
    existing.quantity += 1;
  } else {
    cart.push({ ...product, quantity: 1 });
  }

  saveCart();
  renderCart();
}

function updateQuantity(productId, action) {
  const item = cart.find((entry) => entry.id === productId);
  if (!item) return;

  if (action === "increase") {
    item.quantity += 1;
  } else if (action === "decrease") {
    item.quantity -= 1;
    if (item.quantity <= 0) {
      cart = cart.filter((entry) => entry.id !== productId);
    }
  }

  saveCart();
  renderCart();
}

productListEl.addEventListener("click", (event) => {
  const button = event.target.closest("button");
  if (!button) return;
  addToCart(Number(button.dataset.id));
});

cartListEl.addEventListener("click", (event) => {
  const button = event.target.closest("button");
  if (!button) return;

  updateQuantity(Number(button.dataset.id), button.dataset.action);
});

loadCart();
renderProducts();
renderCart();
