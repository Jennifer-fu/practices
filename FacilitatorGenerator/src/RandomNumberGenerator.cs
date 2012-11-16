using System;

namespace FacilitatorGenerator
{
    public class RandomNumberGenerator
    {
        private int size;
        private Random random;

        public RandomNumberGenerator(int size)
        {
            this.size = size;
            random = new Random();
        }

        public virtual int Next()
        {
            return random.Next(size - 1);
        }
    }
}