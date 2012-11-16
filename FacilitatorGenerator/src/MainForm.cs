using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FacilitatorGenerator
{
    public partial class MainForm : Form
    {
        private Generator generator;

        public MainForm()
        {
            InitializeComponent();
            generator = new Generator(new RandomNumberGenerator(4));
        }

        private void AddPerson_Button_Click(object sender, EventArgs e)
        {
            string name = textBox1.Text;
            generator.AddPerson(name);
            textBox1.Text = "";
            nameList.Items.Add(name);
        }

        private void generateButton_Click(object sender, EventArgs e)
        {
            generator.Run();
            presenter.Text = generator.Presenter;
            lunchOrder.Text = generator.LunchOrder;
        }
    }
}
