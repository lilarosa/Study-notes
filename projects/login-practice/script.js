const STORAGE_KEY = "auth-practice-users";
const LOGIN_STATE_KEY = "auth-practice-current-user";
let users = [];
let currentMode = "login";

const loginForm = document.querySelector("#login-form");
const registerForm = document.querySelector("#register-form");
const formTitle = document.querySelector("#form-title");
const messageBox = document.querySelector("#message");
const switchButtons = document.querySelectorAll(".switch-btn");
const toggleButtons = document.querySelectorAll(".toggle-password");

function loadUsers() {
  try {
    const storedUsers = localStorage.getItem(STORAGE_KEY);
    users = storedUsers ? JSON.parse(storedUsers) : [];
  } catch (error) {
    console.error("读取用户数据失败", error);
    users = [];
  }
}

function saveUsers() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(users));
}

function showMessage(text, type = "success") {
  messageBox.textContent = text;
  messageBox.className = `message ${type}`;
}

function setMode(mode) {
  currentMode = mode;
  switchButtons.forEach((button) => {
    button.classList.toggle("active", button.dataset.mode === mode);
  });

  if (mode === "login") {
    formTitle.textContent = "欢迎回来";
    loginForm.classList.remove("hidden");
    registerForm.classList.add("hidden");
  } else {
    formTitle.textContent = "创建新账户";
    loginForm.classList.add("hidden");
    registerForm.classList.remove("hidden");
  }

  showMessage("");
}

function togglePassword(targetId) {
  const input = document.querySelector(`#${targetId}`);
  if (!input) return;

  const isPassword = input.type === "password";
  input.type = isPassword ? "text" : "password";

  const button = document.querySelector(`.toggle-password[data-target="${targetId}"]`);
  if (button) {
    button.textContent = isPassword ? "隐藏" : "显示";
  }
}

function registerUser(name, email, password) {
  const exists = users.some((user) => user.email === email || user.name === name);
  if (exists) {
    showMessage("用户名或邮箱已存在", "error");
    return;
  }

  users.push({ name, email, password });
  saveUsers();
  showMessage("注册成功，请切换到登录页登录", "success");
  document.querySelector("#register-form").reset();
}

function loginUser(identifier, password, rememberMe) {
  const user = users.find(
    (item) =>
      (item.name === identifier || item.email === identifier) && item.password === password
  );

  if (!user) {
    showMessage("用户名/邮箱或密码不正确", "error");
    return;
  }

  localStorage.setItem(LOGIN_STATE_KEY, JSON.stringify({ name: user.name, email: user.email }));
  if (rememberMe) {
    localStorage.setItem("auth-practice-remembered", "true");
  } else {
    localStorage.removeItem("auth-practice-remembered");
  }

  showMessage(`登录成功，欢迎 ${user.name}`, "success");
  loginForm.reset();
}

switchButtons.forEach((button) => {
  button.addEventListener("click", () => setMode(button.dataset.mode));
});

toggleButtons.forEach((button) => {
  button.addEventListener("click", () => togglePassword(button.dataset.target));
});

loginForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const identifier = document.querySelector("#login-identifier").value.trim();
  const password = document.querySelector("#login-password").value;
  const rememberMe = document.querySelector("#remember-me").checked;

  if (!identifier || !password) {
    showMessage("请填写完整信息", "error");
    return;
  }

  loginUser(identifier, password, rememberMe);
});

registerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const name = document.querySelector("#register-name").value.trim();
  const email = document.querySelector("#register-email").value.trim();
  const password = document.querySelector("#register-password").value;
  const confirmPassword = document.querySelector("#confirm-password").value;

  if (!name || !email || !password || !confirmPassword) {
    showMessage("请填写完整信息", "error");
    return;
  }

  if (password.length < 6) {
    showMessage("密码至少需要 6 位", "error");
    return;
  }

  if (password !== confirmPassword) {
    showMessage("两次输入的密码不一致", "error");
    return;
  }

  registerUser(name, email, password);
});

loadUsers();
setMode("login");
