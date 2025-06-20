let navigateFn: (path: string) => void = null as any;
let pendingPath: string | null = null;

export const setNavigator = (navFn: (path: string) => void) => {
  navigateFn = navFn;
  if (pendingPath) {
    navFn(pendingPath); // flush pending navigation
    pendingPath = null;
  }
};

export const navigate = (path: string) => {
  if (navigateFn) {
    navigateFn(path);
  } else {
    console.warn("Navigator not set yet. Buffering navigation to:", path);
    pendingPath = path;
  }
};
