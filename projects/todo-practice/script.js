const STORAGE_KEY = "todo-practice-items";
let todos = [];
let currentFilter = "all";

const form = document.querySelector("#todo-form");
const input = document.querySelector("#todo-input");
const prioritySelect = document.querySelector("#priority-select");
const list = document.querySelector("#todo-list");
const filterButtons = document.querySelectorAll(".filter-btn");

function loadTodos() {
  try {
    const storedTodos = localStorage.getItem(STORAGE_KEY);
    todos = storedTodos ? JSON.parse(storedTodos) : [];
  } catch (error) {
    console.error("读取数据失败", error);
    todos = [];
  }
}

function saveTodos() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(todos));
}

function getFilteredTodos() {
  switch (currentFilter) {
    case "active":
      return todos.filter((todo) => !todo.completed);
    case "completed":
      return todos.filter((todo) => todo.completed);
    default:
      return todos;
  }
}

function renderTodos() {
  const filteredTodos = getFilteredTodos();

  if (filteredTodos.length === 0) {
    list.innerHTML = '<li class="todo-item">当前没有任务，请添加一个吧。</li>';
    return;
  }

  list.innerHTML = filteredTodos
    .map((todo) => {
      const priorityClass = `priority-${todo.priority}`;
      const priorityText = {
        low: "低优先级",
        medium: "中优先级",
        high: "高优先级",
      }[todo.priority];

      return `
        <li class="todo-item ${todo.completed ? "completed" : ""}" data-id="${todo.id}">
          <div class="todo-main">
            <input class="todo-checkbox" data-id="${todo.id}" type="checkbox" ${todo.completed ? "checked" : ""} />
            <div>
              <div class="todo-text">${todo.text}</div>
              <span class="priority-badge ${priorityClass}">${priorityText}</span>
            </div>
          </div>
          <div class="actions">
            <button class="small-btn edit-btn" type="button">编辑</button>
            <button class="small-btn danger delete-btn" type="button">删除</button>
          </div>
        </li>
      `;
    })
    .join("");
}

function addTodo(text, priority) {
  const newTodo = {
    id: Date.now(),
    text,
    completed: false,
    priority,
  };

  todos.unshift(newTodo);
  saveTodos();
  renderTodos();
}

function toggleTodo(id) {
  todos = todos.map((todo) =>
    todo.id === id ? { ...todo, completed: !todo.completed } : todo
  );
  saveTodos();
  renderTodos();
}

function deleteTodo(id) {
  todos = todos.filter((todo) => todo.id !== id);
  saveTodos();
  renderTodos();
}

function editTodo(id) {
  const todo = todos.find((item) => item.id === id);
  if (!todo) return;

  const newText = window.prompt("请输入新的任务内容", todo.text);
  if (newText === null) return;

  const trimmedText = newText.trim();
  if (!trimmedText) {
    alert("任务内容不能为空");
    return;
  }

  todo.text = trimmedText;
  saveTodos();
  renderTodos();
}

function setFilter(filter) {
  currentFilter = filter;

  filterButtons.forEach((button) => {
    button.classList.toggle("active", button.dataset.filter === filter);
  });

  renderTodos();
}

form.addEventListener("submit", (event) => {
  event.preventDefault();
  const text = input.value.trim();
  const priority = prioritySelect.value;

  if (!text) {
    alert("请输入任务内容");
    return;
  }

  addTodo(text, priority);
  form.reset();
  input.focus();
});

list.addEventListener("click", (event) => {
  const button = event.target.closest("button");
  if (!button) return;

  const todoItem = button.closest(".todo-item");
  if (!todoItem) return;

  const id = Number(todoItem.dataset.id);

  if (button.classList.contains("delete-btn")) {
    deleteTodo(id);
  }

  if (button.classList.contains("edit-btn")) {
    editTodo(id);
  }
});

list.addEventListener("change", (event) => {
  if (event.target.classList.contains("todo-checkbox")) {
    const id = Number(event.target.dataset.id);
    toggleTodo(id);
  }
});

filterButtons.forEach((button) => {
  button.addEventListener("click", () => {
    setFilter(button.dataset.filter);
  });
});

