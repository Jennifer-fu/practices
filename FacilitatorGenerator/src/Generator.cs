using System.Collections.Generic;
using Moq;

namespace FacilitatorGenerator
{
    public class Generator
    {
        private IList<string> nameList;
        private RandomNumberGenerator randomNumberGenerator;

        public Generator(RandomNumberGenerator randomNumberGenerator)
        {
            this.randomNumberGenerator = randomNumberGenerator;
            nameList = new List<string>();
        }

        public void AddPerson(string name)
        {
            nameList.Add(name);
        }

        public void Run()
        {
            if (nameList.Count < 2) throw new PersonNotEnoughException();
            Presenter = nameList[randomNumberGenerator.Next()];
            LunchOrder = nameList[randomNumberGenerator.Next()];
        }

        public string Presenter { get; private set; }

        public string LunchOrder { get; private set; }
    }
}