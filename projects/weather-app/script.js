const API_KEY = "YOUR_API_KEY";
const BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

const form = document.querySelector("#search-form");
const cityInput = document.querySelector("#city-input");
const statusEl = document.querySelector("#status");
const resultEl = document.querySelector("#weather-result");

function setStatus(message) {
  statusEl.textContent = message;
}

function renderWeather(data) {
  const temp = Math.round(data.main.temp - 273.15);
  const feelsLike = Math.round(data.main.feels_like - 273.15);
  const description = data.weather[0].description;

  resultEl.innerHTML = `
    <div class="temp">${temp}°C</div>
    <div><strong>${data.name}</strong></div>
    <div>${description}</div>
    <div>体感温度：${feelsLike}°C</div>
    <div>湿度：${data.main.humidity}%</div>
  `;
}

async function fetchWeather(city) {
  setStatus("正在查询天气...");
  resultEl.innerHTML = "";

  try {
    const response = await fetch(`${BASE_URL}?q=${encodeURIComponent(city)}&appid=${API_KEY}&units=metric&lang=zh_cn`);

    if (!response.ok) {
      throw new Error("城市不存在或查询失败");
    }

    const data = await response.json();
    renderWeather(data);
    setStatus("查询成功");
  } catch (error) {
    resultEl.innerHTML = "<div>查询失败，请稍后再试。</div>";
    setStatus(error.message);
  }
}

form.addEventListener("submit", (event) => {
  event.preventDefault();
  const city = cityInput.value.trim();

  if (!city) {
    setStatus("请输入城市名称");
    return;
  }

  fetchWeather(city);
});
