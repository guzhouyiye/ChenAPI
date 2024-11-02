/**
 * @see https://umijs.org/docs/max/access#access
 * */
export default function access(initialState: InitialState | undefined) {
  const { loginUser } = initialState ?? {};
  console.log('Login User:', loginUser);
  console.log('User Role:', loginUser?.userRole);
  return {
    canUser: loginUser,
    canAdmin: loginUser?.userRole === 'admin',
  };
}
