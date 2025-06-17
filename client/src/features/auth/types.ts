export const AUTH_REDUCER_NAME = "AUTH";
export const FETCH_AUTH_USER = "FETCH_AUTH_USER";
export const LOGIN_SAGA = "LOGIN";
export const SIGNUP_SAGA = "SIGNUP";

export interface IPermission {
  id: number;
  name: string;
}

export interface IRolePermission {
  id: number;
  permission: IPermission;
}

export interface IRole {
  id: number;
  name: string;
  rolePermissions: IRolePermission[];
}

export interface IAuthUser {
  firstName: string;
  lastName: string;
  email: string;
  roles: IRole[];
}

export interface IAuth {
  isAuthenticated: boolean;
  user?: IAuthUser;
}

export interface ISignupPayload {
  email: string;
  firstName: string;
  lastName: string;
  password: string;
}

export interface ILoginPayload {
  email: string;
  password: string;
}
