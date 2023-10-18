from tkinter import*
from tkinter import ttk
import random
import time
import datetime
from tkinter import messagebox
import mysql.connector


class Hospital:
    def __init__(self,root):
        self.root = root
        self.root.title("Hospital Management System")
        self.root.geometry("1540x800+0+0")

        lbtitle = Label(self.root,bd=20,relief=RIDGE,text="HOSPITAL MANAGEMENT SYSTEM",fg="red",bg="white",font=("times new roman",50,"bold"))
        lbtitle.pack(side=TOP,fill=X)

        # ==========================Dataframe===============
        Dataframe = Frame(self.root,bd=20,relief=RIDGE)
        Dataframe.place(x=0,y=130,width=1432,height=400)

        DataframeLeft = LabelFrame(Dataframe,bd=10,padx=20,relief=RIDGE,font=("arial",12,"bold"),text="Patient Information")
        DataframeLeft.place(x=0,y=5,width=900,height=350)

        DataframeRight = LabelFrame(Dataframe,bd=10,padx=20,relief=RIDGE,font=("arial",12,"bold"),text="Prescription")
        DataframeRight.place(x=910,y=5,width=460,height=350)

        # =========================Buttons Frame===================
        ButtonFrame = Frame(self.root,bd=20,relief=RIDGE)
        ButtonFrame.place(x=0,y=530,width=1432,height=70)

        # =========================Details Frame===================
        DetailsFrame = Frame(self.root,bd=20,relief=RIDGE)
        DetailsFrame.place(x=0,y=600,width=1432,height=190)


root=Tk()
ob=Hospital(root)
root.mainloop()