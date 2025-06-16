import axios, { AxiosRequestConfig, AxiosResponse, AxiosHeaders } from "axios";

export const defaultHeaders: Record<string, string> = {
  // Accept: "application/vnd.api+json,application/json",
  // "Content-Type": "application/vnd.api+json",
  // "X-CSRF-TOKEN": window.CSRF_TOKEN
};

const getUriEncodedPath = (path: string[]): string =>
  `/${path.map(encodeURIComponent).join("/")}`;

interface IAPIResponse<T = any> extends AxiosResponse<T> {}

class API {
  static get<T = any>(
    pathSegments: string[] = [],
    params: Record<string, any> = {},
    config: AxiosRequestConfig = {},
    headers: Record<string, string> = defaultHeaders
  ): Promise<IAPIResponse<T>> {
    return axios.get(getUriEncodedPath(pathSegments), {
      headers,
      ...config,
      params,
    });
  }

  static post<T = any>(
    pathSegments: string[] = [],
    body: any = {},
    params: Record<string, any> = {},
    config: AxiosRequestConfig = {},
    headers: Record<string, string> = defaultHeaders
  ): Promise<IAPIResponse<T>> {
    return axios.post(getUriEncodedPath(pathSegments), body, {
      headers,
      ...config,
      params,
    });
  }

  static patch<T = any>(
    pathSegments: string[] = [],
    body: any = {},
    params: Record<string, any> = {},
    config: AxiosRequestConfig = {},
    headers: Record<string, string> = defaultHeaders
  ): Promise<IAPIResponse<T>> {
    return axios.patch(getUriEncodedPath(pathSegments), body, {
      headers,
      ...config,
      params,
    });
  }

  static put<T = any>(
    pathSegments: string[] = [],
    body: any = {},
    params: Record<string, any> = {},
    config: AxiosRequestConfig = {},
    headers: Record<string, string> = defaultHeaders
  ): Promise<IAPIResponse<T>> {
    return axios.put(getUriEncodedPath(pathSegments), body, {
      headers,
      ...config,
      params,
    });
  }

  static delete<T = any>(
    pathSegments: string[] = [],
    params: Record<string, any> = {},
    config: AxiosRequestConfig = {},
    headers: Record<string, string> = defaultHeaders
  ): Promise<IAPIResponse<T>> {
    return axios.delete(getUriEncodedPath(pathSegments), {
      headers,
      ...config,
      params,
    });
  }
}

export default API;
