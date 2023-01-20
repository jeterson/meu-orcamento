export interface CredentialsRequest {
  username: string,
  password: string
}
export interface TokenResponse {
  token: string,
  name: string,
  username: string
}
export interface User {
  id: number,
  username: string,
  name: string
}