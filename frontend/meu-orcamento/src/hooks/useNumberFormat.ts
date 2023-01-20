
const currencyProviders = {
  dollar: new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}),
  real: new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'})
}

const formatToCurrencyBRL = (value: number):string => {
  return currencyProviders.real.format(value)
}
const formatToCurrencyUSD = (value: number):string => {
  return currencyProviders.dollar.format(value)
}
export default () => ({
  formatToCurrencyBRL,
  formatToCurrencyUSD
})