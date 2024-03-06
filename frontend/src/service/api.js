// api.js
import axios from "axios";
const apiRequest = (method, url, data = null) => {
  const tokenJson = localStorage.getItem('token');
  // const token = JSON.parse(tokenJson).jwt;
  const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb3ZlamF2YWEiLCJpYXQiOjE2OTM1NDgyNzEsImV4cCI6MTY5MzU0OTcxMX0.paOnTjofuSedx2T2zZFnP6D8cQdLagLb2cGG8GcskOM";
  return axios({
    method: method,
    url: url,
    data: data,
    headers: {
      Authorization: `Bearer ${token}`, // Đặt token vào tiêu đề Authorization
    },
  });
};

export default apiRequest;
