import { Account } from "src/models/account";
import { TableColumn } from "src/models/table";
import { BaseServiceApi } from "../BaseService";
import useNumberFormat from "src/hooks/useNumberFormat";

export class AccountService extends BaseServiceApi{
  
  async geColumns(): Promise<TableColumn[]> {
    const {formatToCurrencyBRL} = useNumberFormat()
    return Promise.resolve( [      
      {
        name: 'name',
        field: 'name',
        align: 'left',
        label: 'Nome',
        sortable: false
      },
      {
        name: 'bank',
        field: (row: any) => row.bank.name,
        align: 'left',
        label: 'Banco',
        sortable: false
      },
      {
        name: 'type',
        field: 'type',
        align: 'left',
        label: 'Tipo',
        sortable: false
      },
      {
        name: 'balance',
        field: (row: any) => row.balance.amount,
        align: 'left',
        label: 'Saldo',
        sortable: false,
        format: (val: number) => formatToCurrencyBRL(val)
      }
    ])
  }

  async findAll(): Promise<Account[]> {
    try{
      var response = await this.request.get('/accounts');      
      return response.data
    }catch(err) {
      throw this.handleError(err);
    }
  }
}