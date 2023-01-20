import { AccountService } from "src/services/accounts/AccountService";

const service = new AccountService();

const findAll = async () => service.findAll();
const findColumns = async() => service.geColumns();


export default () => ({
  findAll,
  findColumns
})