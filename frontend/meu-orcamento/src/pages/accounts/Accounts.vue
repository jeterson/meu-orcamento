<template>
  <q-card class="q-ma-sm q-pa-none" bordered>
    <q-card-section class="bg-positive text-white">
      <div>Minhas Contas</div>
    </q-card-section>
    <q-card-section>

      <div class="row q-col-gutter-sm">
      <div v-for="account in accounts" class="col-sm-12 col-md-4 col-lg-3">
        <q-card class="account">
          <q-card-section class="account-header">
            <span :style="accoutColorStyle(account)" class="account-name">{{ account.name }}</span>
            <div class="account-balance">
              <div>Saldo Disponível</div>
              <div :style="balanceColorStyle(account.balance.amount)" class="account-balance-amount">{{ formatToCurrencyBRL(account.balance.amount) }}</div>
            </div>
          </q-card-section>
          <q-card-section>
            <div>Tipo</div>
            <div>{{account.accountTypeDescription}}</div>
          </q-card-section>
        </q-card>
      </div>
    </div>

    </q-card-section>
  </q-card>
</template>
<script lang="ts">
import { QCard, QCardSection, QTable } from 'quasar';
import { Account } from 'src/models/account';
import { TableColumn } from 'src/models/table';
import { defineComponent, ref } from 'vue';
import useAccountsService from 'src/hooks/useAccountsService'
import useNumberFormat from 'src/hooks/useNumberFormat'

export default defineComponent({
  mounted() {
    this.loadColumns();
    this.loadAccounts()
  },
  setup() {
    const accounts = ref<Account[]>([]);    
    const { findAll, findColumns } = useAccountsService(); 
    const {formatToCurrencyBRL} = useNumberFormat()

    const columns = ref<TableColumn[]>([]);
    const loadColumns = async () => {
      columns.value = await findColumns()
    }
    const loadAccounts = async () =>  {
      accounts.value = await findAll();
    }
    const accoutColorStyle = (account: Account) => {
      return {color: account.colorHex}
    }
    const balanceColorStyle = (amount: number) => {
      return {color: amount == 0 ? '#000' : amount < 0 ? '#C10015' : '#00600A'}
    }
    return {
      accounts,
      columns,
      loadColumns,
      loadAccounts,
      formatToCurrencyBRL,
      accoutColorStyle,
      balanceColorStyle
    }
  }
});
</script>

<style>
*{
  font-family: 'Poppins', sans-serif;
}
.account-header {
  display: flex;
  justify-content: space-between;
}
.account-header .account-balance {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
.account-header .account-name {
  font-weight: 700;
}
.account-header .account-balance .account-balance-amount {
  font-weight: 700;
  font-size: 16px;
}
</style>