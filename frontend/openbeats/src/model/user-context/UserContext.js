import React, { useReducer, createContext } from "react";

export const UserContext = createContext();

const initialState = {
  user: {
    "userid":13,
    "username":"",
    "password":"$2a$10$JPiZveE9IowoPsrQSyky5ec928qQhpR2xZbne1JqE4iJXouTP0oEe",
    "firstName":"testName",
    "lastName":"L",
    "preferredName":"testName",
    "emailId":"nidic54688@proxiesblog.com",
    "subscriptionType":"free",
    "emailVerified":true,
    "authorities":null,
    "enabled":true,
    "accountNonLocked":true,
    "accountNonExpired":true,
    "credentialsNonExpired":true
  },
  userImage:null,
  sessions:[],
  passcode:"",
  loading: false,
  error: null,
  selectedFile: null
};

const reducer = (state, action) => {
  switch (action.type) {
    case "LOAD_USER":
      return {
        user: action.payload
      };
    case "CREATE_SESSION":
        return {
          sessions: action.payload
        };
    case "STORE_PASSCODE":
      return {
        passcode: action.payload
      };
    case "STORE_IMAGE":
      return {
        userImage: action.payload
      };
    case "STORE_AUDIO":
      return {
        selectedFile: action.payload
      };
    case "DEL_CONTACT":
      return {
        contacts: state.contacts.filter(
          contact => contact.id !== action.payload
        )
      };
    case "START":
      return {
        loading: true
      };
    case "COMPLETE":
      return {
        loading: false
      };
    default:
      throw new Error();
  }
};

const UserContextProvider = props => {
    const [state, dispatch] = useReducer(reducer, initialState);

    return (
        <UserContext.Provider value={[state, dispatch]}>
        {props.children}
        </UserContext.Provider>
    );
};

export default UserContextProvider
