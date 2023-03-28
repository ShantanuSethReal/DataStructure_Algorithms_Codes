import React, { useContext } from "react";
import noteContext from "../context/notes/noteContext";

const Noteitem = (props) => {
  const context = useContext(noteContext);
  const { deleteNote } = context;
  const { note, updateNote } = props;
  const d = new Date(note.date);
  return (
    <div className="col-md-3">
      <div className="card my-3">
        <span className="position-absolute top-0  translate-middle badge rounded-pill bg-danger" style={{ left: "90%", zIndex: "1" }}>
          {note.tag}
        </span>
        <div className="card-body">
          <div class="d-flex">
            <div class="mr-auto p-2">
              <h5 className="card-title">{note.title}</h5>
            </div>
            <div class="p-2">
              {" "}
              <i
                className="far fa-trash-alt mx-2 "
                onClick={() => {
                  deleteNote(note._id);
                }}
              ></i>
            </div>
            <div class="p-2">
              <i
                className="far fa-edit mx-2"
                onClick={() => {
                  updateNote(note);
                }}
              ></i>
            </div>
          </div>
          {/* <div className="d-flex justify-content-between"></div> */}
          <p className="card-text">{note.description}</p>
          <div className="card-footer text-muted" style={{ textAlign: "center", fontSize: 12 }}>
            Created on {d.getDate() + "/" + (d.getMonth() + 1) + "/" + d.getFullYear()}
          </div>
          <p style={{ textAlign: "center", fontSize: 9 }}>{d.toLocaleTimeString()}</p>
        </div>
      </div>
    </div>
  );
};

export default Noteitem;
