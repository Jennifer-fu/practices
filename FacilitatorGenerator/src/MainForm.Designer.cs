namespace FacilitatorGenerator
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.personNameTextBox = new System.Windows.Forms.TextBox();
            this.addPersonButton = new System.Windows.Forms.Button();
            this.generateButton = new System.Windows.Forms.Button();
            this.presenter = new System.Windows.Forms.TextBox();
            this.lunchOrder = new System.Windows.Forms.TextBox();
            this.nameList = new System.Windows.Forms.ListBox();
            this.selectedNameList = new System.Windows.Forms.ListBox();
            this.selectButton = new System.Windows.Forms.Button();
            this.presenterLabel = new System.Windows.Forms.Label();
            this.lunchOrderLabel = new System.Windows.Forms.Label();
            this.unselectButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // personNameTextBox
            // 
            this.personNameTextBox.Location = new System.Drawing.Point(12, 230);
            this.personNameTextBox.Name = "personNameTextBox";
            this.personNameTextBox.Size = new System.Drawing.Size(100, 20);
            this.personNameTextBox.TabIndex = 0;
            // 
            // addPersonButton
            // 
            this.addPersonButton.Location = new System.Drawing.Point(118, 227);
            this.addPersonButton.Name = "addPersonButton";
            this.addPersonButton.Size = new System.Drawing.Size(75, 23);
            this.addPersonButton.TabIndex = 1;
            this.addPersonButton.Text = "AddPerson";
            this.addPersonButton.UseVisualStyleBackColor = true;
            this.addPersonButton.Click += new System.EventHandler(this.AddPerson_Button_Click);
            // 
            // generateButton
            // 
            this.generateButton.Location = new System.Drawing.Point(322, 227);
            this.generateButton.Name = "generateButton";
            this.generateButton.Size = new System.Drawing.Size(75, 23);
            this.generateButton.TabIndex = 2;
            this.generateButton.Text = "Generate";
            this.generateButton.UseVisualStyleBackColor = true;
            this.generateButton.Click += new System.EventHandler(this.generateButton_Click);
            // 
            // presenter
            // 
            this.presenter.Location = new System.Drawing.Point(322, 73);
            this.presenter.Name = "presenter";
            this.presenter.Size = new System.Drawing.Size(100, 20);
            this.presenter.TabIndex = 3;
            // 
            // lunchOrder
            // 
            this.lunchOrder.Location = new System.Drawing.Point(322, 139);
            this.lunchOrder.Name = "lunchOrder";
            this.lunchOrder.Size = new System.Drawing.Size(100, 20);
            this.lunchOrder.TabIndex = 4;
            // 
            // nameList
            // 
            this.nameList.FormattingEnabled = true;
            this.nameList.Location = new System.Drawing.Point(12, 27);
            this.nameList.Name = "nameList";
            this.nameList.Size = new System.Drawing.Size(100, 186);
            this.nameList.TabIndex = 5;
            // 
            // selectedNameList
            // 
            this.selectedNameList.FormattingEnabled = true;
            this.selectedNameList.Location = new System.Drawing.Point(163, 27);
            this.selectedNameList.Name = "selectedNameList";
            this.selectedNameList.Size = new System.Drawing.Size(100, 186);
            this.selectedNameList.TabIndex = 6;
            // 
            // selectButton
            // 
            this.selectButton.Location = new System.Drawing.Point(119, 94);
            this.selectButton.Name = "selectButton";
            this.selectButton.Size = new System.Drawing.Size(38, 23);
            this.selectButton.TabIndex = 7;
            this.selectButton.Text = "=>";
            this.selectButton.UseVisualStyleBackColor = true;
            this.selectButton.Click += new System.EventHandler(this.selectButton_Click);
            // 
            // presenterLabel
            // 
            this.presenterLabel.AutoSize = true;
            this.presenterLabel.Location = new System.Drawing.Point(322, 54);
            this.presenterLabel.Name = "presenterLabel";
            this.presenterLabel.Size = new System.Drawing.Size(77, 13);
            this.presenterLabel.TabIndex = 8;
            this.presenterLabel.Text = "Next Presenter";
            // 
            // lunchOrderLabel
            // 
            this.lunchOrderLabel.AutoSize = true;
            this.lunchOrderLabel.Location = new System.Drawing.Point(322, 120);
            this.lunchOrderLabel.Name = "lunchOrderLabel";
            this.lunchOrderLabel.Size = new System.Drawing.Size(85, 13);
            this.lunchOrderLabel.TabIndex = 9;
            this.lunchOrderLabel.Text = "Nex LunchOrder";
            // 
            // unselectButton
            // 
            this.unselectButton.Location = new System.Drawing.Point(118, 132);
            this.unselectButton.Name = "unselectButton";
            this.unselectButton.Size = new System.Drawing.Size(39, 23);
            this.unselectButton.TabIndex = 10;
            this.unselectButton.Text = "<=";
            this.unselectButton.UseVisualStyleBackColor = true;
            this.unselectButton.Click += new System.EventHandler(this.unselectButton_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(448, 262);
            this.Controls.Add(this.unselectButton);
            this.Controls.Add(this.lunchOrderLabel);
            this.Controls.Add(this.presenterLabel);
            this.Controls.Add(this.selectButton);
            this.Controls.Add(this.selectedNameList);
            this.Controls.Add(this.nameList);
            this.Controls.Add(this.lunchOrder);
            this.Controls.Add(this.presenter);
            this.Controls.Add(this.generateButton);
            this.Controls.Add(this.addPersonButton);
            this.Controls.Add(this.personNameTextBox);
            this.Name = "MainForm";
            this.Text = "MainForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox personNameTextBox;
        private System.Windows.Forms.Button addPersonButton;
        private System.Windows.Forms.Button generateButton;
        private System.Windows.Forms.TextBox presenter;
        private System.Windows.Forms.TextBox lunchOrder;
        private System.Windows.Forms.ListBox nameList;
        private System.Windows.Forms.ListBox selectedNameList;
        private System.Windows.Forms.Button selectButton;
        private System.Windows.Forms.Label presenterLabel;
        private System.Windows.Forms.Label lunchOrderLabel;
        private System.Windows.Forms.Button unselectButton;
    }
}

