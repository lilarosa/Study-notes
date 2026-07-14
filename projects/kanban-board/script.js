const STORAGE_KEY = "kanban-board-tasks";
let tasks = [];
let draggedElement = null;

function loadTasks() {
  try {
    const stored = localStorage.getItem(STORAGE_KEY);
    tasks = stored ? JSON.parse(stored) : getInitialTasks();
  } catch (error) {
    console.error("读取看板数据失败", error);
    tasks = getInitialTasks();
  }
}

function getInitialTasks() {
  return [
    { id: 1, text: "设计首页", status: "todo" },
    { id: 2, text: "开发登录功能", status: "in-progress" },
    { id: 3, text: "修复用户反馈的 bug", status: "done" },
  ];
}

function saveTasks() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(tasks));
}

function renderTasks() {
  document.querySelectorAll(".task-list").forEach((list) => {
    const status = list.dataset.status;
    const tasksByStatus = tasks.filter((task) => task.status === status);

    list.innerHTML = tasksByStatus
      .map((task) => {
        return `
          <li class="task-item" draggable="true" data-id="${task.id}">
            <div class="task-header">
              <span>${task.text}</span>
              <button class="task-delete" type="button">删除</button>
            </div>
          </li>
        `;
      })
      .join("");
  });
}

function addTask(status, text) {
  if (!text.trim()) return;

  tasks.push({
    id: Date.now(),
    text: text.trim(),
    status,
  });

  saveTasks();
  renderTasks();
}

function deleteTask(id) {
  tasks = tasks.filter((task) => task.id !== id);
  saveTasks();
  renderTasks();
}

function moveTask(taskId, newStatus) {
  const task = tasks.find((t) => t.id === taskId);
  if (task) {
    task.status = newStatus;
    saveTasks();
    renderTasks();
  }
}

document.addEventListener("dragstart", (event) => {
  const taskItem = event.target.closest(".task-item");
  if (!taskItem) return;

  draggedElement = taskItem;
  taskItem.classList.add("dragging");
});

document.addEventListener("dragend", (event) => {
  const taskItem = event.target.closest(".task-item");
  if (taskItem) {
    taskItem.classList.remove("dragging");
  }
});

document.addEventListener("dragover", (event) => {
  event.preventDefault();
});

document.addEventListener("drop", (event) => {
  event.preventDefault();

  const list = event.target.closest(".task-list");
  if (!list || !draggedElement) return;

  const taskId = Number(draggedElement.dataset.id);
  const newStatus = list.dataset.status;

  moveTask(taskId, newStatus);
  draggedElement = null;
});

document.addEventListener("submit", (event) => {
  const form = event.target.closest(".add-form");
  if (!form) return;

  event.preventDefault();
  const input = form.querySelector("input");
  const status = form.dataset.status;

  addTask(status, input.value);
  input.value = "";
  input.focus();
});

document.addEventListener("click", (event) => {
  const button = event.target.closest(".task-delete");
  if (!button) return;

  const taskItem = button.closest(".task-item");
  const taskId = Number(taskItem.dataset.id);
  deleteTask(taskId);
});

loadTasks();
renderTasks();
