const STORAGE_KEY = "expense-tracker-items";
let expenses = [];

const form = document.querySelector("#expense-form");
const descriptionInput = document.querySelector("#description");
const amountInput = document.querySelector("#amount");
const categoryInput = document.querySelector("#category");
const dateInput = document.querySelector("#date");
const list = document.querySelector("#expense-list");
const totalExpenseEl = document.querySelector("#total-expense");
const entryCountEl = document.querySelector("#entry-count");

function loadExpenses() {
  try {
    const stored = localStorage.getItem(STORAGE_KEY);
    expenses = stored ? JSON.parse(stored) : [];
  } catch (error) {
    console.error("读取记账数据失败", error);
    expenses = [];
  }
}

function saveExpenses() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(expenses));
}

function renderExpenses() {
  if (expenses.length === 0) {
    list.innerHTML = '<li class="expense-item">还没有任何记录，先添加一条吧。</li>';
  } else {
    list.innerHTML = expenses
      .map((expense) => {
        return `
          <li class="expense-item">
            <div>
              <div>${expense.description}</div>
              <div class="expense-meta">${expense.category} · ${expense.date}</div>
            </div>
            <div>
              <strong>¥${Number(expense.amount).toFixed(2)}</strong>
              <div class="expense-meta">
                <button class="delete-btn" data-id="${expense.id}" type="button">删除</button>
              </div>
            </div>
          </li>
        `;
      })
      .join("");
  }

  const total = expenses.reduce((sum, item) => sum + Number(item.amount), 0);
  totalExpenseEl.textContent = `¥${total.toFixed(2)}`;
  entryCountEl.textContent = expenses.length;
}

function addExpense(description, amount, category, date) {
  expenses.unshift({
    id: Date.now(),
    description,
    amount,
    category,
    date,
  });
  saveExpenses();
  renderExpenses();
}

function deleteExpense(id) {
  expenses = expenses.filter((item) => item.id !== id);
  saveExpenses();
  renderExpenses();
}

form.addEventListener("submit", (event) => {
  event.preventDefault();
  const description = descriptionInput.value.trim();
  const amount = amountInput.value;
  const category = categoryInput.value;
  const date = dateInput.value;

  if (!description || !amount || !date) {
    alert("请填写完整信息");
    return;
  }

  addExpense(description, amount, category, date);
  form.reset();
  dateInput.value = new Date().toISOString().slice(0, 10);
  descriptionInput.focus();
});

list.addEventListener("click", (event) => {
  const button = event.target.closest("button");
  if (!button) return;

  const id = Number(button.dataset.id);
  deleteExpense(id);
});

loadExpenses();
renderExpenses();
