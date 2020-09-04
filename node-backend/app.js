var ip = require("ip");
var express = require("express");
var app = express();

app.get("/api/backend", (req, res, next) => {
  const { greeting } = req.query;
  
  const json = {
    greeting: greeting + " from Cluster Backend",
    time: new Date().getTime(),
    ip: ip.address()
  };
  
  res.json(json);
});

app.listen(3000, () => {
  console.log("Server running on port 3000");
});