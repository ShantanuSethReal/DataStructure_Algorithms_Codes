import React, { useState } from "react";

export default function HookCounter() {
  const ininum = 0;
  const [num, setnum] = useState(ininum);
  const [count, setCount] = useState(0);
  const [name, setName] = useState({ firstName: "", lastName: "" });
  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count {count}</button>
      <h1>Num {num}</h1>
      <button onClick={() => setnum(num + 1)}>Increment</button>
      <button onClick={() => setnum(num - 1)}>Decrement</button>
      <button onClick={() => setnum(ininum)}>Reset</button>
      {/* Better Method Using Previous State*/}
      <button onClick={() => setnum((prevnum) => prevnum - 1)}>Decrement</button>

      <div>
        <form>
          <input type="text" value={name.firstName} onChange={(e) => setName({ ...name, firstName: e.target.value })}></input>
          <input type="text" value={name.lastName} onChange={(e) => setName({ ...name, lastName: e.target.value })}></input>
          <h2>
            {" "}
            Your First Name is {name.firstName} and your last name is{name.lastName}
          </h2>
        </form>
      </div>
    </div>
  );
}
