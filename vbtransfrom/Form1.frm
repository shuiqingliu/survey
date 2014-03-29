VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   4635
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   7740
   LinkTopic       =   "Form1"
   ScaleHeight     =   4635
   ScaleWidth      =   7740
   StartUpPosition =   3  '窗口缺省
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   2160
      TabIndex        =   1
      Top             =   240
      Width           =   3015
   End
   Begin VB.Timer Timer1 
      Enabled         =   0   'False
      Left            =   600
      Top             =   3120
   End
   Begin VB.CommandButton Command1 
      Caption         =   "角度转换为弧度"
      Height          =   975
      Left            =   2280
      TabIndex        =   0
      Top             =   2040
      Width           =   2655
   End
   Begin VB.Label Label1 
      Caption         =   "批量处理角度个数:"
      Height          =   615
      Left            =   240
      TabIndex        =   2
      Top             =   240
      Width           =   1575
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
   Timer1.Enabled = True
    Dim b!
    Dim A() As Single
  
    Do While Not EOF(1)
    Line Input #1, linedate
    s = Split(linedate, " ")
    ReDim A(UBound(s))
    For i = LBound(s) To UBound(s)
        A(i) = Val(s(i))
    Next i
    b = Format((A(0) * 3600 + A(1) * 60 + A(2)) / 206265, "0.000000")
    s = A(0) & "d" & A(1) & "'" & A(2) & "''" & "=========>" & b
    Print #2, s
    Loop
    Close #2
    MsgBox ("计算完成")
    Unload Me
End Sub

Private Sub Form_Load()
    Open "C:\Users\qingliu\Desktop\vb\1.txt" For Input As #1
    Open "C:\Users\qingliu\Desktop\vb\2.txt" For Append As #2
    i = 0
    Timer1.Interval = 1000
End Sub

Private Sub Timer1_Timer()
   i = i + 1
    If i <= Val(Text1.Text) Then
        Command1_Click
    End If
End Sub
