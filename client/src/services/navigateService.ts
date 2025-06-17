let navigateFn: (path: string) => void = (path: string) => {
  throw new Error("Navigate function not set yet.");
};

export const setNavigator = (navFn: (path: string) => void) => {
  navigateFn = navFn;
};

export const navigate = (path: string) => {
  navigateFn(path);
};
