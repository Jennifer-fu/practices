using System;
using System.Windows.Forms;

namespace FacilitatorGenerator
{
    public partial class MainForm : Form,IView
    {
        private readonly Generator generator;
        private Presenter logicPresenter;
        public MainForm()
        {
            InitializeComponent();
            generator = new Generator();
        }

        private void AddPerson_Button_Click(object sender, EventArgs e)
        {
            logicPresenter.OnAddPersonButtonClick();
        }

        private void generateButton_Click(object sender, EventArgs e)
        {
            generator.SetRandomGenerator(new RandomNumberGenerator(selectedNameList.Items.Count));
            generator.Run();
            presenter.Text = generator.Presenter;
            lunchOrder.Text = generator.LunchOrder;
        }

        private void selectButton_Click(object sender, EventArgs e)
        {
            logicPresenter.OnSelectPersonButtonClick();
        }

        private void unselectButton_Click(object sender, EventArgs e)
        {
            var selectedItem = (string) selectedNameList.SelectedItem;
            selectedNameList.Items.Remove(selectedItem);
            nameList.Items.Add(selectedItem);
            generator.RemovePerson(selectedItem);
        }

        public void AddPersonToNameList(string name)
        {
            nameList.Items.Add(name);
        }

        public string GetPersonName()
        {
            return textBox1.Text;
        }

        public void ResetPersonName()
        {
            textBox1.Text = "";
        }

        public void SetPresenter(Presenter presenter)
        {
            logicPresenter = presenter;
        }

        public string GetSelectedPerson()
        {
            return (string) nameList.SelectedItem;
        }

        public void AddPersonToSelectedNameList(string name)
        {
            selectedNameList.Items.Add(name);
        }

        public void RemovePersonFromNameList(string name)
        {
            nameList.Items.Remove(name);
        }
    }
}