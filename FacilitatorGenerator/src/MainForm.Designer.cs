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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.generateButton = new System.Windows.Forms.Button();
            this.presenter = new System.Windows.Forms.TextBox();
            this.lunchOrder = new System.Windows.Forms.TextBox();
            this.nameList = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(12, 230);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 0;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(134, 227);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 1;
            this.button1.Text = "AddPerson";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.AddPerson_Button_Click);
            // 
            // generateButton
            // 
            this.generateButton.Location = new System.Drawing.Point(241, 227);
            this.generateButton.Name = "generateButton";
            this.generateButton.Size = new System.Drawing.Size(75, 23);
            this.generateButton.TabIndex = 2;
            this.generateButton.Text = "Generate";
            this.generateButton.UseVisualStyleBackColor = true;
            this.generateButton.Click += new System.EventHandler(this.generateButton_Click);
            // 
            // presenter
            // 
            this.presenter.Location = new System.Drawing.Point(229, 32);
            this.presenter.Name = "presenter";
            this.presenter.Size = new System.Drawing.Size(100, 20);
            this.presenter.TabIndex = 3;
            // 
            // lunchOrder
            // 
            this.lunchOrder.Location = new System.Drawing.Point(229, 102);
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
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(331, 262);
            this.Controls.Add(this.nameList);
            this.Controls.Add(this.lunchOrder);
            this.Controls.Add(this.presenter);
            this.Controls.Add(this.generateButton);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox1);
            this.Name = "MainForm";
            this.Text = "MainForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button generateButton;
        private System.Windows.Forms.TextBox presenter;
        private System.Windows.Forms.TextBox lunchOrder;
        private System.Windows.Forms.ListBox nameList;
    }
}

