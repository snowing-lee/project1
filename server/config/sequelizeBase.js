//sequelize基础配置文件
const Sequelize = require('sequelize');
const sequelize = new Sequelize('mall', 'root', 'lgl33926', {
	host: '127.0.0.1',
	dialect: 'mysql',
	pass: 'lgl33926',
})

module.exports = sequelize;
