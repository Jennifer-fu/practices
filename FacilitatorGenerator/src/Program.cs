using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace FacilitatorGenerator
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            var view = new MainForm();
            var presenter = new Presenter(view, new Generator());
            view.SetPresenter(presenter);
            Application.Run(view);
        }
    }
}
