import React, { useContext, useState } from "react";
import noteContext from "../context/notes/noteContext";
import { Link } from "react-router-dom";
const AddNote = () => {
  const context = useContext(noteContext);
  const { addNote } = context;
  
  const [note, setNote] = useState({ title: "", description: "", tag: "" });

  const handleClick = (e) => {
    e.preventDefault();
    addNote(note.title, note.description, note.tag);
    setNote({ title: "", description: "", tag: "" });
  };

  const onChange = (e) => {
    setNote({ ...note, [e.target.name]: e.target.value });
  };
  return (
    <div className="container my-3">
      {localStorage.getItem("token")===null?<h4 style={{color: "gray"}}>Please Login to view your archived notes</h4>:""}
      <div className="d-flex justify-content-between bd-highlight mb-3">
        <div className="p-2 bd-highlight">
          <button type="button" className="btn btn-outline-success" style={{ fontSize: 28 }}>
            iNotebook-Dashboard
          </button>
        </div>
        <div className="p-2 bd-highlight"></div>
        <div className="p-2 bd-highlight">
          <Link className="btn btn-warning mx-1" to="/login" role="button" style={{ marginTop: 25 }}>
            LogOut
          </Link>
        </div>
      </div>
      <div className="container">
        <h4>Add New Note </h4>
      </div>
      <div className="container">
        <form className="my-3 mx-2">
          <div className="mb-3">
            <label htmlFor="title" className="form-label">
              Title
            </label>
            <input type="text" className="form-control" id="title" name="title" aria-describedby="emailHelp" value={note.title} onChange={onChange} minLength={5} required />
          </div>
          <div className="mb-3">
            <label htmlFor="description" className="form-label">
              Description
            </label>
            <input type="text" className="form-control" id="description" name="description" value={note.description} onChange={onChange} minLength={5} required />
          </div>
          <div className="mb-3">
            <label htmlFor="tag" className="form-label">
              Tag
            </label>
            <input type="text" className="form-control" id="tag" name="tag" value={note.tag} onChange={onChange} minLength={5} required />
          </div>

          <button disabled={note.title.length < 5 || note.description.length < 5} type="submit" className="btn btn-primary" onClick={handleClick}>
            Add Note
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddNote;
