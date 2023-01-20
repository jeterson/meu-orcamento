import { User } from "./login"

export interface Bank {
  id: number,
  name: string,
  image: string|null
}
export type AccountType = 'CONTA_CORRENTE' | 'INVESTIMENTOS'| 'POUPANCA' | 'OUTROS'| 'CARTEIRA'
export type AccountColor = 'BLUE'|'RED'|'PURPLE'|'BLACK'|'YELLOW'|'BLUE_1'|'GREEN'|'GREEN_1'
export interface Account {
  id: number,
  name: string,
  bank: Bank,
  user: User,
  type: AccountType,
  balance: any
  color: AccountColor
  colorHex: string,
  accountTypeDescription: string
}