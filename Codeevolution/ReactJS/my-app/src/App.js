import logo from "./logo.svg";
import "./App.css";
import Greet from "./components/Greet";
import Welcome from "./components/Welcome";
import Counter from "./components/Counter";
import EventBind from "./components/EventBind";
import Parent from "./components/Parent";
import Forms from "./components/Forms";
import HookCounter from "./components/HookCounter";
//Can recieve props as argument
function App() {
  return (
    <div className="App">
      {/* <Greet name="Bruce" heroName="Batman"></Greet> */}
      {/* <Greet> props.children </Greet>*/}
      {/* <Welcome name="Bruce" heroName="Batman"></Welcome> */}
      {/* <Counter></Counter> */}
      {/* <EventBind></EventBind> */}
      {/* <Parent></Parent> */}
      {/* <Forms></Forms> */}
      <HookCounter></HookCounter>
    </div>
  );
}

export default App;
